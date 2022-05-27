# FlashScoreFeignClient

It is a simple Spring project consuming [Football API](https://www.api-football.com/) using OpenFeign declarative client.

## How to run
Sign up on [rapidapi](https://rapidapi.com/api-sports/api/api-football/) for free plan to get your api-key and put it in `application.properties` file as follows:
```
rapidapi.key=your_assigned_key
rapidapi.host=your_assigned_host
```

Use maven or maven wrapper to run:

```bash
mvn spring-boot:run
```
