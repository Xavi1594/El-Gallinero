import ArticlePublicRepository from "./ArticlePublicRepository";
import UserPublicRepository from "./UserPublicRepository";

export default class GlobalApiRepository{

    api;

    constructor(apiToCharge) {
        this.api = apiToCharge;
        this.chooseApi();
    }

    chooseApi() {
        if(this.api === "user") {
            return new UserPublicRepository;
        }
        if(this.api === "article") {
            return new ArticlePublicRepository;
        }
    }
}
