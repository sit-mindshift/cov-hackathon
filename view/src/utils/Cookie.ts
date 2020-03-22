function findCookieByName (name: string) {
    const match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    return match ? JSON.parse(match[2]) : null;
}

export function setLoginCookie(customer: any) {
    return document.cookie = `session=${JSON.stringify(customer)};path=/`;
}

export function getLoginCookie() {
    return findCookieByName('session');
}