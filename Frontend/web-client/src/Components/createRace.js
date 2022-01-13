function createRace() {

    const addRace = (event) => {
        event.preventDefault(); //prevent page from reloading after submitting form
        console.log(event.target.race.value); //get value from form
        document.getElementById("addrace").innerHTML = event.target.race.value; //get value from form and show it on the page

    }

    return (

        <div className="addrace">
            <form onSubmit={addRace}>
                <h3>Create a race</h3>
                <textarea name="addrace" className="form-control mt-3" id="" cols="30" rows="10" name="addrace"></textarea>
                <button type="submit" className="btn btn-success mt-3 float-end">Send</button>
            </form>
        </div>

        )

}
