import requests

def get_html(url):
    # 模仿浏览器的headers
    headers = {
        "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36"
    }

    response = requests.get(url,headers=headers)
    lyric = response.json()['lyric']
    
    with open("lyric.txt", "w", encoding='utf-8') as f:
        f.write(lyric)
    print("done")

if __name__ == "__main__":
    get_html("http://music.163.com/api/song/media?id=1468192805")

