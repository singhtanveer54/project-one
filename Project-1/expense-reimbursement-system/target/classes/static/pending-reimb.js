window.addEventListener("load", async () => {
    let res = await fetch(`http://localhost:8080/checkloginstatus`, {
      method: "GET",
      credentials: "include",
    });
  
    if (res.status === 200) {
      let userObj = await res.json();
  
      if (userObj.role === "employee") {
        window.location.href = "employee-homepage.html";
      }
      let fnLn = document.querySelector('#fnLn');
        fnLn.innerHTML = `Welcome ${userObj.firstName} ${userObj.lastName}`; 
  
      console.log("userObj>>>", userObj);
      
  
    } else if (res.status === 401) {
      window.location.href = "index.html";
    }
  
    pendingReimbursement();
  });
  
  async function pendingReimbursement() {
    let res = await fetch("http://localhost:8080/reimbursement/status/Pending", {
      credentials: "include",
      method: "GET",
    });

    
  let tbodyElement = document.querySelector("#reimb_table tbody");
  tbodyElement.innerHTML = "";

  let reimbArray = await res.json();
  console.log("reimbArray>>",reimbArray)

  for (let i = 0; i < reimbArray.length; i++) {
    let reimbursement = reimbArray[i];

    let tr = document.createElement("tr");

    let td1 = document.createElement("td");
    td1.innerHTML = reimbursement.id;

    let td2 = document.createElement("td");
    td2.innerHTML = reimbursement.amount;

    let td3 = document.createElement("td");
    td3.innerHTML = reimbursement.submitted;

    let td4 = document.createElement("td");
    td4.innerHTML = reimbursement.resolved;

    let td5 = document.createElement("td");
    td5.innerHTML = reimbursement.description;

    let td6 = document.createElement("td");
    td6.innerHTML = reimbursement.aFirstName;

    let td7 = document.createElement("td"); //resolverId
    td7.innerHTML = reimbursement.rFirstName;

    let td8 = document.createElement("td"); // status
    td8.innerHTML = reimbursement.status;

    let td9 = document.createElement("td");
    td9.innerHTML = reimbursement.reimType;

    let td10 = document.createElement("td"); 

    let viewImageButton = document.createElement('button');
    viewImageButton.innerHTML = 'View Receipt';

    td10.appendChild(viewImageButton);

    viewImageButton.addEventListener("click", () => {
      let reimbImageModal = document.querySelector('#reimb-image-modal');

      let modalCloseElement = reimbImageModal.querySelector('button');
      modalCloseElement.addEventListener('click', () =>{
          reimbImageModal.classList.remove('is-active');
      });

      let modalContentElement = reimbImageModal.querySelector('.modal-content');
      modalContentElement.innerHTML = '';

      let imageElement = document.createElement("img");
      imageElement.setAttribute(
        "src",
        `http://localhost:8080/reimbursement/${reimbursement.id}/image`
      );
      modalContentElement.appendChild(imageElement);

      reimbImageModal.classList.add("is-active");
    })

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6);
    tr.appendChild(td7);
    tr.appendChild(td8);
    tr.appendChild(td9);
    tr.appendChild(td10);
    

    tbodyElement.appendChild(tr);
}
  }