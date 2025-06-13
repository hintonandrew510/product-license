function validationForm() {
    const startDateString = document.getElementById("startDate").value;
    const endDateString =document.getElementById("endDate").value;
    
    const startDate = new Date(startDateString);
    const endDate =new Date(endDateString);
    
    if (startDate > endDate) {
        alert("Start date is earlier than end date");
        return false;
    }
}

