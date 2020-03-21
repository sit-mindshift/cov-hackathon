import httpClient from './HttpClient';
import loading from '@/store/models/loading';
// @ts-ignore
export function setupInterceptors({ dispatch }) {
  let requestsPending = 0;
  const req = {
    pending: () => {
      requestsPending++;
      loading.show();
    },
    done: () => {
      requestsPending--;
      if (requestsPending <= 0) {
        loading.hide();
      }
    },
  };
  httpClient.interceptors.request.use(
    (config) => {
      req.pending();
      return config;
    },
    (error) => {
      requestsPending--;
      req.done();
      return Promise.reject(error);
    },
  );
  httpClient.interceptors.response.use(
    ({ data }) => {
      req.done();
      return Promise.resolve(data);
    },
    (error) => {
      req.done();
      return Promise.reject(error);
    },
  );
}
