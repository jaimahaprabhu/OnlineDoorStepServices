export class HttpResoponseError {
    constructor(status?: number, errorMessage?: string, errorDescription?: string) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }
    public status?: number;
    public errorMessage?: string;
    public errorDescription?: string;
}