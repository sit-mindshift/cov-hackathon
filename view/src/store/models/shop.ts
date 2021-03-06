/* tslint:disable:no-console */
import store, {RootState} from '../store';
import {BareActionContext, getStoreBuilder} from 'vuex-typex';
import shopRepository from '@/repositories/shopRepository';

export class Shop {
  public id: string;
  public type: string;
  public latitude: number;
  public longitude: number;
  public zipcode: string;
  public city: string;
  public street: string;
  public openinghours: string;

  public constructor(id: string, latitude: number, longitude: number,
                     zipcode: string, city: string, street: string,
                     openinghours: string) {
    this.id = id;
    this.type = 'Lidl';
    this.latitude = latitude;
    this.longitude = longitude;
    this.zipcode = zipcode;
    this.city = city;
    this.street = street;

    // https://css-tricks.com/snippets/javascript/strip-html-tags-in-javascript/
    const withComma = openinghours.replace(/(<([^>]+)>)/ig,', ');
    this.openinghours = withComma.substring(0, withComma.length - 2);
  }
}

export interface ShopState {
  shops: Shop[];
}

const initialShopState: ShopState = {
  shops: [],
};
const b = getStoreBuilder<RootState>().module('shops', initialShopState);

// getters
const shopsGetter = b.read((state) => state.shops, 'productGetter');
const shopByIdGetter = b.read(
  (state) => (i: string) =>
    state.shops.filter((s) => {
      return s.id === i;
    }), 'shopsFilter');

// mutations
function setShopList(state: ShopState, payload: { shops: Shop[] }) {
  state.shops = payload.shops;
}

// action
async function readShopList(context: BareActionContext<ShopState, RootState>) {
  const newShops: Shop[] = await shopRepository.getShops()
    || initialShopState.shops;
  shops.setShopList({shops: newShops});
}


// state
const stateGetter = b.state();

// exported "model" module interface
const shops = {
  // state
  get state() {
    return stateGetter();
  },
  // getters
  get allShops() {
    return shopsGetter();
  },
  getShopById(i: string) {
    return shopByIdGetter()(i);
  },
  // mutations
  setShopList: b.commit(setShopList),

  // actions
  dispatchReadShopList: b.dispatch(readShopList),

};

export default shops;




