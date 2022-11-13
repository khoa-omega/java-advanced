function register() {
    $.ajax({
        method: 'POST',
        url: 'http://localhost:8080/api/v1/auth/register',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify({
            username: $('#username').val(),
            firstName: $('#first-name').val(),
            lastName: $('#last-name').val(),
            password: $('#password').val(),
            role: $('#role').val()
        }),
        success: () => {
            showToast(
                'Đăng ký thành công.',
                'Chúng tôi đang chuyển hướng bạn đến trang đăng nhập...'
            );
            setTimeout(() => location.replace('/page/auth/login/index.html'), 2000);
        },
        error: () => showToast('Đăng ký thất bại.', 'Vui lòng thử lại.')
    });
}

function showToast(title, message) {
    $('#toast-title').text(title);
    $('#toast-body').text(message);
    bootstrap.Toast.getOrCreateInstance($('#toast')).show();
}
