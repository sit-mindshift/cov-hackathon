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
