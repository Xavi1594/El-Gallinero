export default class ArticlesPublicRepository{
    url = "http://localhost:8080/api/articles";

    constructor() {}

    async getAll() {
        const response = await fetch(this.url);
        const json = await response.json();

        let articleList = [];

        articleList.push(json);
        return json
    }
}