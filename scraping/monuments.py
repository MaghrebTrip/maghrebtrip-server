import requests
from bs4 import BeautifulSoup
import pandas as pd
import time

monuments_url = "https://en.wikipedia.org/wiki/List_of_sites_and_monuments_in_Morocco"

def get_monuments_urls():
    response = requests.get(monuments_url)
    soup = BeautifulSoup(response.text, 'html.parser')
    table = soup.find('table', class_='wikitable')
    rows = table.findAll('tr')
    monuments = {}
    for row in rows[1:]:
        tds = row.findAll('td')
        city = tds[0].text.strip()
        url = tds[1].find('a')['href']
        url = 'https://en.wikipedia.org' + url
        monuments[city] = url
    df = pd.DataFrame(monuments.items(), columns=['city', 'url'])
    df.to_csv('./monuments_urls.csv', index=False)

def get_monument_data(city, url, df_data):
    print(f'Getting data for {city}...')
    time.sleep(5) # sleep for 5 seconds to avoid getting blocked
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')
    table = soup.find('table', class_='wikitable')
    rows = table.findAll('tr')
    for row in rows[1:]:
        tds = row.findAll('td')
        image = tds[0]
        if image.find('img'):
            image = image.find('img')['src']
            image = 'https:' + image
        else:
            image = ''
        # tds[1] is None
        name = tds[2].text.strip()
        location = tds[3].text.strip()
        coordinates = tds[4].text.strip()
        identifier = tds[5].text.strip()
        df_data = df_data._append({'city': city, 'image': image, 'name': name, 'location': location, 'coordinates': coordinates, 'identifier': identifier}, ignore_index=True)
        df_data.to_csv('./monuments_data.csv', index=False)
    print(f'Done with {city}.')
    print('-----------------------------------')

def get_monuments_data():
    df = pd.read_csv('./monuments_urls.csv')
    df_data = pd.DataFrame(columns=['city', 'image', 'name', 'location', 'coordinates', 'identifier'])
    for index, row in df.iterrows():
        city = row['city']
        url = row['url']
        get_monument_data(city, url, df_data)

def continue_getting_data():
    df = pd.read_csv('./monuments_urls.csv')
    df_data = pd.read_csv('./monuments_data.csv')
    cities_done = df_data['city'].unique()
    cities_todo = df[~df['city'].isin(cities_done)]
    for index, row in cities_todo.iterrows():
        city = row['city']
        url = row['url']
        get_monument_data(city, url, df_data)

# get_monuments_data()
# continue_getting_data()
