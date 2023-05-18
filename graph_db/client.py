import cmd
import requests
import json




class MyShell(cmd.Cmd):
    intro = 'Welcome to distributed graph db. Type help or ? to list commands.\n'
    prompt = 'distributed_graphdb > '

    def do_greet(self, arg):
        'Greet the user.'
        print('Hello,', arg)
    
    def do_ping(self, arg):
        'Ping the server.'
        
        
    
    def default(self, line):
        url = 'http://www.localhost:8080/query'
        # set header for content type
        headers = {'Content-Type': 'application/json'}
        
        # send post request with body query : line
        json_data = {"query": line}
        body = json.dumps(json_data)
        # print response
        response = requests.post(url, body, headers = headers)
        print(response.text)

       

    def do_quit(self, arg):
        'Exit the shell.'
        return True

if __name__ == '__main__':
    MyShell().cmdloop()
