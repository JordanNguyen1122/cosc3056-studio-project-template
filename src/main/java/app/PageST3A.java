package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageST3A implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page3A.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Subtask 3.1</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
            <div class='topnav'>
                <a href='/'>Homepage</a>
                <a href='mission.html'>Our Mission</a>
                <a href='page2A.html'>Sub Task 2.A</a>
                <a href='page2B.html'>Sub Task 2.B</a>
                <a href='page3A.html'>Sub Task 3.A</a>
                <a href='page3B.html'>Sub Task 3.B</a>
            </div>
        """;

        // Add header content block
        html = html + """
            <div class='header'>
                <h1>Subtask 3.A</h1>
            </div>
        """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <form action = '/page2.html' method = 'post'>

            <div>

                <label for = 'World or Country Selector' class = 'padding-style-1'> Selected world or countries: </label>

                <select id = 'World or Country Selector' name = 'World or country Selector' class = 'style-2' style = 'padding-right: 200px;
                margin-bottom: 20px'>

                    <option> World </option>

                    <option> Country </option>

                    <option> State </option>
                </select>
            </div>

            <br></br>
            Start: <select name="yearpicker" id="yearpicker"></select>
            <br/>
            End: <select name="yearpicker2" id="yearpicker2"></select>
            
            <script type="text/javascript"
                    src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"> 
            </script>
            <script type="text/javascript">
            let startYear = 2008;
            let endYear = 2021;
            for (i = endYear; i > startYear; i--)
            {
                $('#yearpicker, #yearpicker2').append($('<option />').val(i).html(i));
            }
            
            $('select').on('change', function(){
              let arr = Array.from({length:$('#yearpicker2').val() - +$('#yearpicker').val()},(v,k)=>k + +$('#yearpicker').val())
              console.log(arr);
            })
            </script>
            """;

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC3056 - Studio Project Starter Code</p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}
