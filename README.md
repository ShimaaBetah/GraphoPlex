[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<br />
<div align="center">
  <a href="https://github.com/ShimaaBetah/GraphoPlex">
    <h1>GraphoPlex</h1>
  </a>

  <p align="center">
A distributed graph database engine that stores users' graph-like data with a supported query language.
</p>
    <br />
     href="https://drive.google.com/file/d/1Jc09WC5AsXW4AQ3AddiRQJFJITIfJX8w/view?usp=sharing">View Demo</a>
    ·
    <a href="https://github.com/ShimaaBetah/GraphoPlex/issues">Report Bug</a>
    ·
    <a href="https://github.com/ShimaaBetah/GraphoPlex/issues">Request Feature</a>
  </p>
</div>

## Motivation
Nowadays, in our data-driven world, various industries and domains are recognizing
the immense value of graph databases. Social Networks, Recommendation Systems, and
Bio-informatics are examples of such domains that could benefit from using a graph
database to store and process their intricate and interconnected data. Unlike traditional
SQL(tabular) databases, graph databases provide flexible semantics that aligns with busi-
ness models in addition to eliminating the unnecessary overhead associated with SQL
databases when querying complex and interconnected data. In addition, the increasing
amount of data needed to be stored requires graph database systems to be distributed
across multiple server

## Architecture
GraphoPlex consists of a client (an interactive shell in Python) and a cluster (multiple servers that run the same code and were implemented in Java).
The client could be connected to any server in the cluster through an HTTP connection to send user queries. 
Inter-cluster communication is done through gRPC.


<p align=center>
<img src="./images/sys_arch (1).png" alt="System Architecture" style="width:600px;"/>
</p>



## Getting Started
### Prerequisites
1) Python 3.6 or higher
2) Java 17 or higher
3) Maven 3.6.3 or higher
4) Docker
5) Redis


### Installation & Setup
1) Clone the repository
```bash
git clone https://github.com/ShimaaBetah/GraphoPlex.git && cd GraphoPlex
```


2) Build the Server
```bash
cd graph_db && mvn install
```

## Usage
1) Run the Server (this will only run 1 server on default 8080 port)
```bash
mvn spring-boot:run
```

2) Run the client
```bash 
python3 client.py
```

3) Start writing commands

   see section 3.2.2 in the <a href="https://github.com/ShimaaBetah/GraphoPlex/blob/main/thesis.pdf"> thesis</a> for more details about the supported commands.


## How to run a cluster
The previous steps will only run 1 server on default 8080 port, to run a cluster of servers, you need to run the following commands.

1) Setup app properties

    open the file `graph_db/src/main/resources/application.properties` and change the following properties
    ```bash 
    server.numOfServers= ${number of servers you want in the cluster}
    grpc.servers.ports= ${grpc ports of the servers in the cluster separated by comma}
    grpc.servers.hosts= ${ip address of the servers in the cluster separated by comma}
    ```
2) Build the server code
    ```bash
    cd graph_db && mvn install
    ```
3) Build Docker Image
    ```bash
    docker build -t graphdb-server .
    ```
4) Run Docker Container 


   ```
   docker run --network="host"  -e SERVER_ID=${server_id} -e REDIS_PORT=${redis_port} -e SERVER_PORT=${http_port} -e GRPC_SERVER_PORT=${grpc_port}  graphdb-server
   
   ```

   this should be done for each server replacing all environment variables by actual values for each server in the cluster. 
   Note that if `server.numOfServers` in `application.properties` is `n` then SERVER_ID should be between `0` and `n-1`.

   Also GRPC_SERVER_PORT should be the element with index of (SERVER_ID) in the array of `grpc.servers.ports` in the `application.properties` file .

5) Run the client
    ```bash 
    python3 client.py
    ```
    make sure that the `url` in client.py is belongs to one of the servers in the cluster
6) Start writing commands as before

## Roadmap
The project is NOT in active development. However, the following ideas are things that would be looked up next: 
- [ ] Parallel implementation for Dijkstra and DFS
- [ ] Result Set visualization
- [ ] Partitioning Strategy Enhancement 
- [ ] Result Set Visualization
- [ ] Authentication and support for multiple users
    


## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the GNU General Public License v3.0. See `LICENSE.txt` for more information.

## Contact

Elshimaa Betah - shimaabetah1911@gmail.com






[contributors-shield]: https://img.shields.io/github/contributors/ShimaaBetah/GraphoPlex.svg?style=for-the-badge
[contributors-url]: https://github.com/ShimaaBetah/GraphoPlex/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/ShimaaBetah/GraphoPlex.svg?style=for-the-badge
[forks-url]: https://github.com/ShimaaBetah/GraphoPlex/network/members
[stars-shield]: https://img.shields.io/github/stars/ShimaaBetah/GraphoPlex.svg?style=for-the-badge
[stars-url]: https://github.com/ShimaaBetah/GraphoPlex/stargazers
[issues-shield]: https://img.shields.io/github/issues/ShimaaBetah/GraphoPlex.svg?style=for-the-badge
[issues-url]: https://github.com/ShimaaBetah/GraphoPlex/issues
[license-shield]: https://img.shields.io/github/license/ShimaaBetah/GraphoPlex.svg?style=for-the-badge&
[license-url]: https://github.com/ShimaaBetah/GraphoPlex/blob/master/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/shimaa-ahmed2864/
[product-screenshot]: images/screenshot.png
