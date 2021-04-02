<template>

  <div class="container">
<!--    <div v-if="people.length !== 0">-->
      <div v-for="person in people" :key="person.id">
        <h3>{{ person.id }}
        <input type="text" v-model="person.name">
        <input type="text" v-model="person.lastname">
          <input type="text" v-model="person.lastname1">
          <input type="text" v-model="person.lastname2">
          <input type="text" v-model="person.lastname3">
          <input type="text" v-model="person.lastname4">
        </h3>
        <button class="btn danger" @click="$emit('remove', person.id)">Удалить</button>
        <button class="btn danger" @click="$emit('update', person.id, person.name, person.lastname, person.lastname1, person.lastname2, person.lastname3, person.lastname4)">Сохранить</button>
<!--        <button class="btn" @click="$emit('update', person.id)">Редактировать</button>-->
<!--        <button class="btn" @click="$emit('save', person.id)">Сохранить</button>-->
      </div>
  </div>
<!--    <div class="card center" v-else>-->
<!--      <h4>Людей пока нет.</h4>-->
<!--      <button class="btn" @click="$emit('load')">Загрузить список</button>-->
<!--    </div>-->
<!--  </div>-->
</template>

<script>
export default {
  name: "VladilenList",
  // data() {
  //   return {
  //     id: '',
  //     name: '',
  //     lastname: '',
  //   }
  // },
  emits: ['load', 'remove', 'update', 'save'],
  props: ['people'],
  // watch: {
  //   people(newVal, oldVal) {
  //     this.id = newVal.id
  //     this.neme = newVal.name
  //     this.lastname = newVal.lastname
  //   }
  // },
}
</script>

<style scoped>
/*.inline {*/
/*  display: flex;*/
/*  justify-content: space-between;*/
/*  align-items: center;*/
/*}*/
</style>