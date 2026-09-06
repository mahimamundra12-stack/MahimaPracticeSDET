function futureDateValue() {
    const date = new Date();

    date.setDate(date.getDate() + 7);

    const pad = (num) => String(num).padStart(2, '0');

    return `${date.getFullYear()}-${pad(date.getMonth() + 1)}-${pad(date.getDate())}T${pad(date.getHours())}:${pad(date.getMinutes())}`;
}

module.exports = { futureDateValue };