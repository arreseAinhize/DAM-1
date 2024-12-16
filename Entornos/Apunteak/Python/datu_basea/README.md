# Gure datu-basea

Datu-basea era erraz baten montatzeko docker erabiliko dugu. Horretarako instalatu [docker](https://docs.docker.com/engine/install/ubuntu/) eta [docker-compose](https://docs.docker.com/compose/install/). Ondoren exekutatu komandoak

Martxan jartzeko:

```bash
$ docker-compose up -d
```

## Datu-basearen egitura hasieratzeko:

Datu-basea martxan jarri ostean, nabigatzailean http://localhost:8080 ireki (root/root)

Ezkerreko menuko "Importar" erabiliz SQL fitxategia inportatu.

## Datu-basea esportatzeko

```bash
$ docker-compose exec db sh -c 'exec mysqldump -d ordenagailuak -uroot -proot' > db.sql
```
