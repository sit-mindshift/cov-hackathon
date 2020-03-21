import Vue from 'vue';
import Vuex, { Store } from 'vuex';
import {getStoreBuilder} from 'vuex-typex';
import {ShopState} from '@/store/models/shop';
import {LoadingState} from '@/store/models/loading';
import {UserState} from "@/store/models/user";

export interface RootState {
    store: ShopState;
    loading: LoadingState;
    user: UserState;
}

Vue.use(Vuex);
const store: Store<RootState> = getStoreBuilder<RootState>().vuexStore();
export default store;
