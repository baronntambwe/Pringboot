FROM cassandra:latest
EXPOSE 9042
RUN useradd -ms /bin/bash admin
COPY ./docker-entrypoint.sh ./docker-entrypoint.sh
RUN chown -R admin:admin ./docker-entrypoint.sh ./etc/cassandra 
RUN chmod a+x docker-entrypoint.sh
COPY initial-seed.cql docker-entrypoint-initdb.d/initial-seed.cql
USER admin
