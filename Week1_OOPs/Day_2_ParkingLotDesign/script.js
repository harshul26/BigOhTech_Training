let parkingSpots = 5;

function parkVehicle() {

    const vehicleNumber =
        document.getElementById("vehicleNumber").value;

    const vehicleType =
        document.getElementById("vehicleType").value;

    const parkingArea =
        document.getElementById("parkingArea");

    if (parkingSpots <= 0) {
        alert("Parking Full");
        return;
    }

    const vehicleCard =
        document.createElement("div");

    vehicleCard.classList.add("vehicle-card");

    vehicleCard.innerHTML = `
        <h3>${vehicleType}</h3>
        <p>Vehicle Number: ${vehicleNumber}</p>
        <p>Spot Allocated: ${parkingSpots}</p>
    `;

    parkingArea.appendChild(vehicleCard);

    parkingSpots--;

    document.getElementById("vehicleNumber").value = "";
}
