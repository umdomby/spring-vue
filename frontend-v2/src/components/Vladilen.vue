<template>

  <div>
    <button class=”Search__button” @click="loadPeople()">CALL Spring Boot REST backend service</button>
<!--    <button class=”Search__button” @click="nullRestService()">Null</button>-->
<!--    <h3>{{ people }}</h3>-->

    <vladilen-list :people="people" > </vladilen-list>

  </div>


</template>

<script>
    import VladilenList from "./VladilenList.vue";

    // import api from "./backend-api";
    import axios from 'axios'

    export default {
      name: 'message',
      data() {
        return {
          response: [],
          errors: [],
          people: [],
        }
      },
      methods: {
        async loadPeople() {
          try {
            const {data} = await axios.get('/api/vladilen')

            this.people = Object.keys(data).map(key => {
              return {
                id: key,
                ...data[key],
                // name: data[key].name,
                // lastname: data[key].lastname
              }
            })
          }catch(e){
            this.alert = {
              type: 'danger',
              title: 'Ошибка!',
              text: 'e'
            }
          }
          console.log(this.people)
        },
      },

      components: {
        VladilenList
      }
    }
</script>

<style>

</style>
