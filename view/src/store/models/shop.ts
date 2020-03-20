import {RootState} from '../store';
import {getStoreBuilder} from 'vuex-typex';

export class Shop {
  public id: number;
  public latitude: number;
  public longitude: number;

  public constructor(id: number, latitude: number, longitude: number) {
    this.id = id;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}

export interface ShopState {
  shops: Shop[];
}

const initialShopState: ShopState = {
  shops: [
    new Shop(
      1,
      13,
      15,
    ),
    new Shop(
      2,
      345,
      5676,
    ),
    new Shop(
      3,
      3424,
      1234,
    ),
  ],
};
const b = getStoreBuilder<RootState>().module('shops', initialShopState);

// getters
const shopsGetter = b.read((state) => state.shops, 'productGetter');
const shopByIdGetter = b.read(
  (state) => (i: number) =>
    state.shops.filter((s) => {
      return s.id === i;
    }), 'shopsFilter');

// state
const stateGetter = b.state();

// exported "model" module interface
const shops = {
  // state
  get state() {
    return stateGetter();
  },
  get allShops() {
    return shopsGetter();
  },
  getShopById(i: number) {
    return shopByIdGetter()(i);
  },
};

export default shops;




