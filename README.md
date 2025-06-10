# GraphQL Spring Boot Application for User Lookup and Post Management

UserLookup is a robust Spring Boot application showcasing the power and flexibility of GraphQL for managing user and post data. This project demonstrates how to build an efficient API where clients can query precisely the data they need — no more, no less — and mutate data with ease.

Designed for simplicity yet extensibility, UserLookup includes features like user retrieval, paginated queries, post creation, and relationship management between users and their posts.

## Features
- GraphQL API with clearly defined types, queries, mutations, and input types.
- Layered architecture: Model, Repository, Service, Resolver
- Custom exception handling
- Input validation 
- Pagination and filtering support
- Retrieve individual users or all users. 
- Fetch posts authored by a specific user.
- Create new users and posts via mutations.
- Relationship handling: users have multiple posts, and posts reference their author.
- Clean and extendable GraphQL schema for easy enhancements.
- In-memory H2 database for quick setup and testing.

## Technologies

- Java 17
- Spring Boot 3
- Spring GraphQL
- Spring Data JPA
- H2 Database

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/graphql-springboot-crud-demo.git
   cd graphql-springboot-crud-demo
   ```

2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Access the GraphQL endpoint at http://localhost:8080/graphql.

## Sample Queries

### Fetch a user by ID

```graphql
query {
  getUser(id: "1") {
    id
    name
    email
    posts {
      id
      title
    }
  }
}
```
### Fetch all users (non-paginated)

```graphql
query {
   getAllUsers {
      id
      name
      email
   }
}
```

### Fetch users with pagination (page 0, size 2)

```graphql
query {
  getUsersPaged(page: 0, size: 2) {
    id
    name
    email
  }
}
```

### Fetch posts by user
```graphql
query {
  getPostsByUser(userId: "1") {
    id
    title
    content
  }
}
```
## Sample Mutations

### Create a new user

```graphql
mutation {
  createUser(input: { name: "Alice Johnson", email: "alice@example.com" }) {
    id
    name
    email
  }
}
```

### Create new post for a user

```graphql
mutation {
  createPost(input: { title: "GraphQL with Spring", content: "Content goes here", authorId: "1" }) {
    id
    title
    author {
      id
      name
    }
  }
}
```

## Testing GraphQL API with Postman

You can test the UserLookup GraphQL API using Postman either by sending raw JSON requests or using Postman’s native GraphQL support.

---

### 1. Using Raw JSON Body (POST request)

- **Step 1:** Open Postman and create a new **POST** request.
- **Step 2:** Set the request URL to:

  ```bash
  http://localhost:8080/graphql
    ```

**Step 3:** Go to the **Headers** tab and ensure you have:

| Key          | Value             |
|--------------|-------------------|
| Content-Type | application/json  |

**Step 4:** Go to the **Body** tab, select **raw**, and choose **JSON** as the format.

**Step 5:** Paste your GraphQL query or mutation inside a JSON object with the `query` key.

**Example Query:**

```json
{
  "query": "query { getUser(id: \"1\") { id name email posts { id title } } }"
}
```

**Example Mutation:**
```json
{
"query": "mutation { createUser(input: { name: \"Alice\", email: \"alice@example.com\" }) { id name email } }"
}
```
**Step 6:** Click **Send**. You should receive a JSON response with data.

![1.png](assets%2F1.png)
![2.png](assets%2F2.png)
![4.png](assets%2F4.png)


### Custom Exception Handling
![3.png](assets%2F3.png)

### 2. Using Postman’s Native GraphQL Request Type
**Step 1:** Create a new request in Postman.

**Step 2:** Set the HTTP method to **POST** and the URL to:
```bash
http://localhost:8080/graphql
```
Go to the **Headers** tab and ensure you have:

| Key          | Value             |
|--------------|-------------------|
| Content-Type | application/json  |

**Step 3:** Instead of selecting raw body, switch to the **GraphQL** tab (next to Body).
**Step 4:** In the **QUERY** section, write your GraphQL query or mutation, for example:

```graphql
query {
  getUser(id: "1") {
    id
    name
    email
    posts {
      id
      title
    }
  }
}
```
**Step 5:** If your query requires variables, add them in the VARIABLES section in JSON format. For example:

```json
{
  "id": "1"
}
```
**Step 6:** Click **Send** to execute the query and view the response.

### 3. Create a new request using Postman’s GraphQL interface
**Step 1:** Open Postman and create a new request.
**Step 2:** No need to set the request method, just add the URL:
```bash
http://localhost:8080/graphql
```
Go to the **Headers** tab and ensure you have:

| Key          | Value             |
|--------------|-------------------|
| Content-Type | application/json  |
**Step 3:** Import the GraphQL schema by clicking on the **Query** tab and then **Import Schema**. This will allow Postman to understand the types and queries available in your GraphQL API.

**Step 4:** You can just select the query or mutation you want to execute from the list of available operations. And add any required variables in the VARIABLES section.

**Step 5:** Click **Send** to execute the query or mutation and view the response.
![5.png](assets%2F5.png)
![6.png](assets%2F6.png)

## How to Access the H2 Database Console

Once your Spring Boot application is running with the H2 database enabled, you can access the H2 web console to view and interact with the database.

### Steps to Access:

1. **Run your application.**  
   Make sure the app is running locally (e.g., on port 8080).

2. **Open your web browser.**

3. **Navigate to the H2 console URL:**
```bash
   http://localhost:8080/h2-console
   ```
4. **Configure the connection settings:**
    - **JDBC URL:** `jdbc:h2:mem:testdb` (or whatever you configured in your `application.properties`)
    - **User Name:** `sa`
    - **Password:** (leave blank)
5. **Click on the "Connect" button.**
You should now be able to see the H2 console where you can run SQL queries, view tables, and manage your in-memory database.

![7.png](assets%2F7.png)

> **Important:**
> Since the database is in-memory, all data will be lost when the application stops. This console is mainly for development and debugging purposes.



