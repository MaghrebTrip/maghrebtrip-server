import requests
from bs4 import BeautifulSoup
import pandas as pd
import random

urls = [
    'https://www.visitmorocco.com/en/travel/rabat',
    'https://www.visitmorocco.com/en/travel/casablanca',
    'https://www.visitmorocco.com/en/travel/tangier',
    'https://www.visitmorocco.com/en/travel/ifrane',
    'https://www.visitmorocco.com/en/travel/fez',
    'https://www.visitmorocco.com/en/travel/dakhla',
    'https://www.visitmorocco.com/en/travel/marrakesh',
    'https://www.visitmorocco.com/en/travel/meknes',
    'https://www.visitmorocco.com/en/travel/safi',
    'https://www.visitmorocco.com/en/travel/chefchaouen'
]

cities = {}



def get_cities():
    for url in urls:
        response = requests.get(url)
        soup = BeautifulSoup(response.text, 'html.parser')
        
        bloc = soup.find('div', class_='field-item even')
        city = bloc.find('h2').text.strip()

        print("City: ", city)

        ps = bloc.findAll('p')
        about = ''
        for p in ps:
            about += p.text.strip() + '\n'

        image = soup.find('div', class_='populaire').find('img')['src']

        cities[city] = {
            'about': about,
            'image': image
        }
        

    df = pd.DataFrame(cities).T
    df.index.name = 'city'

    df.to_csv('cities.csv')

def download_images():
    df = pd.read_csv('cities.csv')
    df.set_index('city', inplace=True)
    df_copy = df.copy()
    df_copy['image_bytes'] = None
    for city in df_copy.index:
        url = df_copy.loc[city, 'image']
        response = requests.get(url)
        bytes = response.content
        print("City: ", city)
        print("Image: ", url)
        print("Status code: ", response.status_code)
        # convert the image to string
        image_str = str(bytes)
        # write in file
        with open(f'{city}.jpg', 'wb') as f:
            f.write(bytes)
        # save the image bytes in the dataframe
        df_copy.loc[city, 'image_bytes'] = bytes

    df_copy.to_csv('cities.csv')

def add_rating():
    df = pd.read_csv('cities.csv')
    df.set_index('city', inplace=True)
    df_copy = df.copy()
    ratings = [random.uniform(3, 5) for _ in range(len(urls))]
    df_copy['rating'] = [round(rating, 2) for rating in ratings]
    df_copy.to_csv('cities.csv')

# drop Unnamed: 0 column
df = pd.read_csv('cities.csv')
df.set_index('city', inplace=True)
df.drop(columns='Unnamed: 0', inplace=True)
df.to_csv('cities.csv')