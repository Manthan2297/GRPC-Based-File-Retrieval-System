# 🚀 gRPC-Based Distributed File Retrieval System

This project is a distributed document indexing and search system built using **gRPC**. It allows multiple clients to connect to a central server, index local documents, and perform keyword-based search queries remotely. The system is optimized for scalability and uses **Protocol Buffers (Protobuf)** for efficient communication.

---

## 💡 Overview

The system demonstrates how gRPC and Protobuf can be used for:
- Remote Procedure Calls (RPC) between clients and server
- Efficient transfer of search and indexing data
- Concurrent request handling and secure communication

---

## ⚙️ Features

✅ Document indexing using file content  
✅ Multi-word search using AND logic  
✅ Ranked results by term frequency  
✅ Protobuf-based schema for clean, structured communication  
✅ Multi-client, concurrent processing supported  
✅ CLI-based client with connection and query support  
✅ Modular and scalable gRPC service definitions

---

## 🧱 Architecture

```plaintext
+---------+         +-------------------+         +--------+
| Client  | <-----> |  gRPC Server      | <-----> | Index  |
| CLI     |         |  (Java/Python)    |         | Store  |
+---------+         +-------------------+         +--------+
     |                      |                          |
 [Index, Search]      [gRPC Services]        [In-Memory or Persistent DB]
