import requests
from bs4 import BeautifulSoup
import pandas as pd
import time
import re

cities = {}

def get_cities():
    url = 'https://en.wikipedia.org/wiki/List_of_cities_in_Morocco'
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')

    table = soup.find('table', class_='wikitable')
    columns = table.find('tr').find_all('th')
    rows = table.find_all('tr')[1:]

    for row in rows:
    
        th = row.find('th')
        tds = row.find_all('td')

        city = th.text.strip()
        city = city.split('[')[0].strip() # remove citation

        link = th.find('a')['href'].strip()
        link = f'https://en.wikipedia.org{link}'

        population = tds[0].text.strip()
        region = tds[1].text.strip()

        print("City: ", city)

        time.sleep(1)

        about, image = get_city_details(link)
        about = clean_about(about)
        
        cities[city] = {
            'population': population,
            'region': region,
            'about': about,
            'image': image
        }

    df = pd.DataFrame(cities).T
    df.index.name = 'city'

    df.to_csv('cities.csv')

def get_city_details(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')
    about = soup.find('div', class_='mw-body-content').find('p').text.strip()
    image = pd.NA
    try:
        table = soup.find('table', class_='infobox')
        row = table.find('tr', class_='mergedtoprow')
        td = row.find('td', class_='infobox-full-data')
        a = td.find('a')
        img = a.find('img')
        image = img['src']
        image = f'https:{image}'
    except:
        pass
    
    return about, image

def clean_about(about):
    about = about.replace('\n', ' ')
    about = about.replace('\xa0', ' ')
    about = re.sub(r'\[.*?\]', '', about)
    about = re.sub(r'\(.*?\)', '', about)
    return about

get_cities()