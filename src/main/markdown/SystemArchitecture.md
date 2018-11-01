# Systems and Architecture Questions

## Rate limiting

### Design a server-side rate limiting service
Question: As a provider of a public API, I want to issue API tokens to users and ensure they don't exceed a certain rate limit (e.g. requests over an hour period).

Things to look for:
* What data structures do they choose, if any? Usually, Queue is the first choice
* Do they account for concurrency? How about runtime?
* Do they handle rate limiting calculations synchronously?

How to complicate the question:
* How do we handle rate limiting in a concurrent environment?
* How do we handle rate limiting across a horizontally scaled service?
* What does runtime look like if we have hundreds of clients making thousands of requests per minute?
