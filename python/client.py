#
# author gino
# created on 16/02/2018
import json

import requests

if __name__ == '__main__':

    response = requests.get("http://localhost:8080/stock/transaction", stream=True)

    for line in response.iter_lines():

        # filter out keep-alive new lines
        if line:
            decoded_line = line.decode('utf-8')
            print(json.loads(decoded_line))
