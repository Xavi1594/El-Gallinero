import { defineStore } from 'pinia'
import { ref } from 'vue';

export const articleStore = defineStore ('articleStore', () => {
	const articleObject = ref([]);
	return articleObject
})