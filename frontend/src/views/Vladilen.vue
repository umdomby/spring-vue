<template>
  <div class="container">
    <form class="card" @submit.prevent="createPerson">
      <h2>Работа с базой данных</h2>
        <div class="form-control">
          <label for="name">Введите имя</label>
          <input type="text" id="name" v-model.trim="name">
          <label for="lastname">Введите фамилию</label>
          <input type="text" id="lastname" v-model.trim="lastname">
        </div>
      <button class="btn primary" :disabled="name.length === 0" >Создать человека</button>
    </form>
  </div>

  <vladilen-list
                 :people="people"
                 @load="loadPeople"
  ></vladilen-list>
</template>

<script>

import VladilenList from "@/views/VladilenList";
import axios from "axios";

export default {
  name: "vladilen",
  data() {
    return {
      name: '',
      lastname: '',
      people: []
    }
  },
  methods: {
    async createPerson() {
      const response = await fetch('/api/vladilen', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          name: this.name,
          lastname: this.lastname
        })
      })
      const firebaseData = await response.json()
      console.log(firebaseData)
      this.name = ''
      this.lastname = ''
    },
    async loadPeople() {
      const {data} = await axios.get('/api/vladilen')
      this.people = Object.keys(data).map(key => {
        return {
          id: key,
          ...data[key],
          // name: data[key].name,
          // lastname: data[key].lastname
        }
      })
      console.log(this.people)
    }
  },
  components: {
    VladilenList
  }
}
</script>

<style scoped>

</style>