# ecom-java-devops-lab

Sample Java (Spring Boot) e-commerce app for DevOps lab: Docker, Kubernetes (EKS), ALB Ingress, RDS MySQL. Includes manifests and ready for CI/CD.

## Run locally with Docker Compose
```bash
docker compose up --build
# app → http://localhost:8080
```

## Build with Maven
```bash
mvn clean package
```

## Environment variables (used by app)
- `DB_HOST` (default: `localhost`)
- `DB_NAME` (default: `ecom`)
- `DB_USER` (default: `root`)
- `DB_PASSWORD` (default: `password`)

## Kubernetes
Manifests in `k8s/`. Create DB secret before deploy:
```bash
kubectl create ns ecom
kubectl -n ecom create secret generic ecom-db   --from-literal=DB_HOST=<rds-endpoint>   --from-literal=DB_NAME=ecom   --from-literal=DB_USER=<db-user>   --from-literal=DB_PASSWORD=<db-pass>

kubectl apply -k k8s/
```
