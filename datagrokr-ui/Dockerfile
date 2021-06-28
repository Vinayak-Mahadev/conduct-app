### STAGE 1: Build ###
FROM node:lts-alpine AS build
RUN mkdir -p /home/appuser
WORKDIR /home/appuser

COPY . .
RUN npm install
RUN npm run build
CMD ["npm", "start"]

### STAGE 2: Run ###
FROM nginx:alpine
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /home/appuser/dist/datagrokr-ui /usr/share/nginx/html
EXPOSE 80
