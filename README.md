## Run locally
In your IDE, run the class com.example.Application (in src/main/java)

## Testing REST endpoints

```
curl -X POST http://localhost:9000/fooEntities -H "Content-Type: application/json" -d "{ \"bar\": \"test value\" }"
curl -X GET http://localhost:9000/fooEntities
```

## Deploying to ECS
