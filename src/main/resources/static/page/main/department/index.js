var sort = '';

$(function () {
    $('#c-modal-wrapper').load('/page/main/department/modal/create.html');
    $('#u-modal-wrapper').load('/page/main/department/modal/update.html');
    $('#d-modal-wrapper').load('/page/main/department/modal/delete.html');

    if (sessionStorage.getItem('role') == 'ADMIN') {
        $('#btn-add').show();
        $('#btn-edit').show();
        $('#btn-delete').show();
    } else if (sessionStorage.getItem('role') == 'MANAGER') {
        $('#btn-add').show();
        $('#btn-edit').show();
    }

    addListeners();
    loadDepartments();
});

function addListeners() {
    $('#page-number').on('keypress', event => {
        if (event.key == 'Enter') {
            loadDepartments();
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
        loadDepartments();
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

function loadDepartments() {
    const params = {
        page: $('#page-number').val(),
        size: $('#page-size').val(),
        sort: sort,
        search: $('#search').val(),
        type: $('#type').val(),
        minCreatedYear: $('#min-created-year').val(),
        minTotalAccounts: $('#min-total-accounts').val(),
        maxTotalAccounts: $('#max-total-accounts').val(),
        minCreatedAt: $('#min-created-at').val(),
        maxCreatedAt: $('#max-created-at').val()
    }
    $.ajax({
        method: 'GET',
        url: 'http://localhost:8080/api/v1/departments?' + new URLSearchParams(params),
        beforeSend: () => $('#loading').show(),
        success: page => {
            updateButtons();
            updatePage(page);
            showDepartments(page.content);
            $('#loading').hide();
        },
        error: () => location.replace('/common/error/404-not-found.html')
    });
}

function showDepartments(departments) {
    const tbody = $('#tbody');
    tbody.empty();
    for (const department of departments) {
        tbody.append(`
            <tr>
                <th class='id'>${department.id}</th>
                <td class='name'>${department.name}</td>
                <td class='total-members'>${department.totalMembers}</td>
                <td class='type'>${department.type}</td>
                <td class='created-at'>${department.createdAt}</td>
                <td class='updated-at'>${department.updatedAt}</td>
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
        loadDepartments();
    }
}
