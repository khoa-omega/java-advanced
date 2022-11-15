var sort = '';

$(function () {
    $('#c-modal-wrapper').load('/page/main/account/modal/create.html');
    $('#u-modal-wrapper').load('/page/main/account/modal/update.html');
    $('#d-modal-wrapper').load('/page/main/account/modal/delete.html');

    if (sessionStorage.getItem('role') == 'ADMIN') {
        $('#btn-add').show();
        $('#btn-edit').show();
        $('#btn-delete').show();
    } else if (sessionStorage.getItem('role') == 'MANAGER') {
        $('#btn-add').show();
        $('#btn-edit').show();
    }

    addListeners();
    loadAccounts();
});

function addListeners() {
    $('#page-number').on('keypress', event => {
        if (event.key == 'Enter') {
            loadAccounts();
        }
    });

    $('#tbody').on('click', 'tr', function (event) {
        if (event.ctrlKey) {
            $(this).toggleClass('selected');
        } else {
            $(this).addClass('selected').siblings().removeClass('selected');
        }
        updateButtons();
    });

    $('#thead').on('click', 'th', function () {
        $(this).siblings().find('i').removeClass('fa-sort-up fa-sort-down').addClass('fa-sort');

        const i = $(this).find('i');
        if (i.hasClass('fa-sort')) {
            i.removeClass('fa-sort').addClass('fa-sort-up');
        } else {
            i.toggleClass('fa-sort-up fa-sort-down');
        }

        const key = $(this).attr('sort');
        const value = i.hasClass('fa-sort-up') ? 'asc' : 'desc';
        sort = `${key},${value}`;
        loadAccounts();
    });
}

function updateButtons() {
    const length = $('.selected').length;
    if (length == 0) {
        $('#btn-edit').attr('disabled', 'disabled');
        $('#btn-delete').attr('disabled', 'disabled');
    } else if (length == 1) {
        $('#btn-edit').removeAttr('disabled');
        $('#btn-delete').removeAttr('disabled');
    } else {
        $('#btn-edit').attr('disabled', 'disabled');
        $('#btn-delete').removeAttr('disabled');
    }
}

function loadAccounts() {
    const params = {
        page: $('#page-number').val(),
        size: $('#page-size').val(),
        sort: sort,
        search: $('#search').val(),
        role: $('#role').val(),
        minId: $('#min-id').val(),
        maxId: $('#max-id').val()
    };
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/api/v1/accounts?' + new URLSearchParams(params),
        beforeSend: () => $('#loading').show(),
        success: page => {
            updateButtons();
            updatePage(page);
            showAccounts(page.content);
            $('#loading').hide();
        },
        error: () => location.replace('/common/error/404-not-found.html')
    });
}

function showAccounts(accounts) {
    const tbody = $('#tbody');
    tbody.empty();
    for (const account of accounts) {
        tbody.append(`
            <tr>
                <th class='id'>${account.id}</th>
                <td class='full-name'>${account.fullName}</td>
                <td class='username'>${account.username}</td>
                <td class='role'>${account.role}</td>
                <td class='department-name'>${account.departmentName}</td>
            </tr>
        `);
    }
}

function updatePage(page) {
    if (page.last) {
        $('#next').addClass('disabled');
    } else {
        $('#next').removeClass('disabled');
    }
    if (page.first) {
        $('#previous').addClass('disabled');
    } else {
        $('#previous').removeClass('disabled');
    }
}

function addPage(value) {
    const page = $('#page-number');
    const number = +page.val() + value;
    if (number > 0) {
        page.val(number);
        loadAccounts();
    }
}
