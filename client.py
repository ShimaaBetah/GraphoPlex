import cmd
import requests
import json


def color_string(text, color_code):
    return f"\x1b[{color_code}m{text}\x1b[0m"

class MyShell(cmd.Cmd):
    intro = 'Welcome to GraphoPlex the distributed graph database. Type help or ? to list commands.\n'
    prompt = color_string('GraphoPlex > ', 91)        
        
    
    def default(self, line):
        
        url = 'http://127.0.0.1:8081/query'
        # set header for content type
        headers = {'Content-Type': 'application/json'}
        
        # send post request with body query : line
        json_data = {"query": line}
        body = json.dumps(json_data)
        # print response
        response = requests.post(url, body, headers = headers)
        print(response.text+"\n")

       

    def do_quit(self, arg):
        'Exit the shell.'
        return True

if __name__ == '__main__':
    MyShell().cmdloop()



