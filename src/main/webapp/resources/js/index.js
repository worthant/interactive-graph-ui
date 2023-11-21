import { updateDateTime } from './utils.js';

$(document).ready(() => {
    updateDateTime();
    setInterval(updateDateTime, 10000);
})