export default class UserPublicRepository {
    url = "http://localhost:8080/api/users";

    constructor() {}

    async getAll() {
        const response = await fetch (this.url);
        const json = await response.json();

        let usersList = [];

        usersList.push(json);

        return json;
    }
}