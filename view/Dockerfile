<<<<<<< HEAD
FROM node:latest as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY ./ .
ARG API_URL
ENV VUE_APP_API_URL=$API_URL
ARG APPLE_MAPS_TOKEN
ENV VUE_APP_APPLE_MAPS_TOKEN=$APPLE_MAPS_TOKEN
RUN npm run build

FROM nginx as production-stage
RUN mkdir /app
COPY --from=build-stage /app/dist /app
COPY nginx.conf /etc/nginx/nginx.conf
=======
FROM node:10.15.0 as ui-builder
RUN mkdir /usr/src/app
WORKDIR /usr/src/app
ENV PATH /usr/src/app/node_modules/.bin:$PATH
COPY package.json /usr/src/app/package.json
RUN npm install
RUN npm install -g @vue/cli
COPY . /usr/src/app
RUN npm run build

FROM nginx
ARG API_URL
ENV API_URL=$API_URL
ARG APPLE_MAPS_TOKEN
ENV APPLE_MAPS_TOKEN=$APPLE_MAPS_TOKEN
COPY  --from=ui-builder /usr/src/app/dist /usr/share/nginx/html
EXPOSE 8081
CMD ["nginx", "-g", "daemon off;"]
>>>>>>> parent of 68e60cd... Push Env Vars to builder again
