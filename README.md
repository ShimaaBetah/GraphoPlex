# GraphoPlex
## Description
GraphoPlex is a distributed graph database engine that stores users' graph-like data with a supported query language.

## Architecture
GraphoPlex consists of a client (an interactive shell in Python) and a cluster (multiple servers that run the same code and were implemented in Java).
The client could be connected to any server in the cluster through an HTTP connection to send user queries. 
Inter-cluster communication is done through gRPC.


<p align=center>
<img src="./images/sys_arch (1).png" alt="System Architecture" style="width:600px;"/>
</p>



## Usage
### Prerequisites
1) Python 3.6 or higher
2) Java 17 or higher
3) Maven 3.6.3 or higher
4) Docker 

### Installation
1) Clone the repository
```bash
git clone https://github.com/ShimaaBetah/GraphoPlex.git && cd GraphoPlex
```


2) Build the Server
```bash
cd graph_db && mvn install
```

3) Run the Server (this will only run 1 server on default 8080 port)
```bash
mvn spring-boot:run
```

4) Run the client
```bash 
python3 client.py
```

5) Start writing commands

   see section 3.2.2 in the thesis for more details about the commands


### How ro run a cluster
the previous steps will only run 1 server on default 8080 port, to run a cluster of servers, you need to run the following commands









