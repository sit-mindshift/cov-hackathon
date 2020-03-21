<script>
import { createMapkit } from 'vue-mapkit'
import user from "../store/models/user";

export default {
  data(){
    return { map: null }
  },
  computed: {
      map_id() {
          return `map-${this._uid}`
      },
    },
    mounted() {
      createMapkit(this.map_id, { language: 'de' }).then(map => {
        // use `map` to perform any changes
        this.map = map
        const self = this
        window.mapkit.addEventListener('configuration-change', function configurationChanged() {
           self.map.center = new window.mapkit.Coordinate(user.state.latitude, user.state.longitude)
           self.map.cameraDistance = 10000

            // @Hase @Alex, hier stores auf map anzeigen siehe Beispie ldas ich geklaut habe
           var MarkerAnnotation = mapkit.MarkerAnnotation;
           var lidBFH = new mapkit.Coordinate(user.state.latitude, user.state.longitude)
           var lidlAnnotation = new MarkerAnnotation(lidBFH, { color: "#f4a56d", title: "SFO", glyphText: "✈️" });
           map.showItems([lidlAnnotation]);

           window.mapkit.removeEventListener('configuration-change', configurationChanged)
        })

      })
    }
  }
</script>
<template>
    <div :id="map_id" style="height: 300px;"></div>
</template>