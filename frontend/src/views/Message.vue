<template>

  <div>
    <button class=”Search__button” @click="callRestService()">CALL Spring Boot REST backend service</button>
    <button class=”Search__button” @click="nullRestService()">Null</button>
    <h3>{{ response }}</h3>
  </div>

</template>

<script>

    // import api from "./backend-api";
    import axios from 'axios'

    export default {
      name: 'message',
      data() {
        return {
          response: [],
          errors: [],
        }
      },
      methods: {
        callRestService() {
          axios.get(`/api/message`)
          //api.message(`/api/message`)
              .then(response => {
                this.response = response.data
              })
              .catch(e => {
                this.errors.push(e)
              })
        },
        nullRestService() {
          this.response = ''
        }
      }
    }
</script>

<style>

</style>
