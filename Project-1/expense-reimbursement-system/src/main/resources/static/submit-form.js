// Initial page load
window.addEventListener('load', async () => {

    let res = await fetch('http://localhost:8080/checkloginstatus', {
        credentials: 'include',
        method: 'GET'
    });

    if (res.status === 200) {
        let userObj = await res.json();

        if (userObj.userRole === 'manager') {
            window.location.href = 'manager-homepage.html';
        }
        let fnLn = document.querySelector('#fnLn');
      fnLn.innerHTML = `Submit new reimbursement ${userObj.firstName} ${userObj.lastName}`;
    } else if (res.status === 401) {
        window.location.href = 'index.html';
    }
});


// Logout btn
let logoutBtn = document.querySelector('#logout');

logoutBtn.addEventListener('click', async () => {

    let res = await fetch('http://localhost:8080/logout', {
        'method': 'POST',
        'credentials': 'include'
    });

    if (res.status === 200) {
        window.location.href = 'index.html';
    }

})

// Submitting assignment
let reimbursementSubmitButton = document.querySelector('#submit-reimbursement-btn');

reimbursementSubmitButton.addEventListener('click', submitReimbursement);

async function submitReimbursement() {

    let reimbursementAmountInput = document.querySelector('#amount');
    let reimbursementImageInput = document.querySelector('#reimbursement-file');
    let reimbursementDescInput = document.querySelector('#description');
    let reimbursementTypeInput = document.querySelector('#reimbType')

    const file = reimbursementImageInput.files[0];
    //console.log("image>>>", file);
   

    let formData = new FormData();
    formData.append('amount', reimbursementAmountInput.value);
    formData.append('reimbType', reimbursementTypeInput.value);
    formData.append('reimb_receipt', file);
    formData.append('description', reimbursementDescInput.value);


    console.log("image>>>", file);
    console.log("amount>>",reimbursementAmountInput.value);
    console.log("type>>",reimbursementTypeInput.value);
    console.log("desc>>",reimbursementDescInput.value);


    let res = await fetch('http://localhost:8080/reimbursement', {
        method: 'POST',
        credentials: 'include',
        body: formData
    });

    if (res.status === 201) { // If we successfully added an assignment
        //populateTableWithReimbursement(); // Refresh the table of assignments
    } else if (res.status === 400) {
        let reimbursementForm = document.querySelector('#reimbursement-submit-form');

        let data = await res.json();

        console.log(data);

        let pTag = document.createElement('p');
        pTag.innerHTML = data.message;
        pTag.style.color = 'red';

        reimbursementForm.appendChild(pTag);
    }
}