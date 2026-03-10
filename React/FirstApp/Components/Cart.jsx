

export const Cart = (props) => {
    return (
        <>
            <div className="container">
                <div className="row justify-content-center">
                    <div className="col-lg-4 py-5">
                        <div className="p-3 shadow-lg ">
                            <div>
                                <img className="img-fluid" src="/Image/Image.jpg" alt="Logo" />
                            </div>
                            <h3>{props.title}</h3>
                            <p>{props.name}</p>
                            <button className="btn btn-primary">Click Me</button>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}
export default Cart