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
    <a href="https://github.com/ShimaaBetah/GraphoPlex/blob/main/thesis.pdf"><strong>Explore the thesis »</strong></a>
    <br />
    <br />
    <a href="https://drive.google.com/file/d/1Jc09WC5AsXW4AQ3AddiRQJFJITIfJX8w/view?usp=sharing">View Demo</a>
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
