$(function () {
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/api/v1/auth/login',
        success: profile => $('.full-name').text(profile.fullName),
        // error: () => location.replace('/common/error/404-not-found.html')
    });
});
