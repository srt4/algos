# OOP Design

## Inheritance

### Implement a multi-protocol URL class structure
Question: We are implementing a client library and need to define a URL in a way that's easy for users to interact with. Our library should support multiple protocols, but allow us to pass them through different layers as URL objects. How would you implement this?

Things to look for:
* Follow-up questions on how this interface would be used
* Discussion of different protocols (e.g. SFTP, HTTP, HTTPS)
* What belongs in the interface and what belongs in concrete implementations
* User-focused development: is the candidate looking to create a reusable solution?

Ideal answers:
* The candidate should understand that a URL includes protocol, hostname, port, and path
* Ideally, example subclasses of HTTP and HTTPS, where both contain query parameters (and thus have a common ancestor of an HttpUrl), but one supports encryption while the other does not
* Avoids including protocol-specific information in the URL interface
