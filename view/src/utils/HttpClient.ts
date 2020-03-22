import axios from 'axios';

let baseURL: string =
  process.env.API_URL ? process.env.API_URL : 'http://localhost:8080';

export default axios.create({
    baseURL,
});
