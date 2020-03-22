import axios from 'axios';

let baseURL: string =
  process.env.VUE_APP_API_URL ? process.env.VUE_APP_API_URL : 'http://localhost:8080';

export default axios.create({
    baseURL,
});
