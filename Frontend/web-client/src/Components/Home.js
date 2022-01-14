function Home() {

    return (
        <div className="mt-5">
            <h2 className="welcome-header">FullStack application for a harbour system</h2>

            <h3 className="mt-5 instructions-header">Non-functional requirements</h3>
            <div className="col-md-6">
                <ul className="list">
                    <li>It must be implemented as a modern Single Page Application</li>
                    <li>The backend must be implemented with Java, JPA, REST (with JAX-RS) and a MySQL database</li>
                    <li> We do expect Test Cases for most of what you do on the backend, both UnitTests and Integration Tests (testing your REST API)</li>
                    <li>The frontend must be implemented with React</li>
                    <li>The project must use a modern DevOps pipeline, using “github actions” to provide a build server. This should be the VERY FIRST thing you set up, and we expect it to build, run your tests and deploy to your droplet which should be set up with your own domain name and use HTTPS.</li>
                    <li>We expect that you can demonstrate your project, both locally (so we can add changes) and remotely on your Droplet.</li>
                    <li>The “product owner” has come up with this initial domain model. Feel free to add missing fields and also change it, as long as you can provide arguments for why you made the changes.</li>
                    <li>Setup test data in the database any way you like</li>
                </ul>
            </div>



            <h3 className="mt-5 instructions-header">Functional requirements</h3>
            <div className="col-md-6">
                <div className="p-4 bg-light instructions-box">
                    <li className="instructions-list">The site requires the users to authenticate for all operations and only an admin can update and create new races, cars and drivers. Users and roles are not shown in the model above. If you have a ready to use start project with support for this, feel free to use it for the application.</li>
                    <li className="instructions-list">For the client application, we would like the following features written up as user stories here:</li>
                    <li>Add any features you find relevant (to showcase your skills) if they are not present in the above list.</li>
                </div>
            </div>
        </div>
    )
}

export default Home;