#!/bin/bash

# Read recipients from JSON file
recipients=$(grep -o '"Maillist": "[^"]"' config.json | cut -d'"' -f4)
subject="Pipeline $1: Job $2 [$3]"

# Define output values
pipelineStatus=$1
consoleOutputUrl=$2
buildNumber=$3

# Define the path to the email body file
htmlFilePath="${WORKSPACE}/email_body.html"

# Create an HTML file for the email body
cat <<EOF > "${htmlFilePath}"
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>Pipeline Run Details</h2>
    <table>
        <tr>
            <th>Output Name</th>
            <th>Output Value</th>
        </tr>
        <tr>
            <td>Jenkins Pipeline Status</td>
            <td>${pipelineStatus}</td>
        </tr>
        <tr>
            <td>Console Output URL</td>
            <td><a href="${consoleOutputUrl}">${consoleOutputUrl}</a></td>
        </tr>
        <tr>
            <td>Build Number</td>
            <td>${buildNumber}</td>
        </tr>
    </table>
    <p>Regards,</p>
    <p>Your Name</p>
</body>
</html>
EOF

# Send email with HTML content to each recipient
for recipient in ${recipients}; do
    mutt -e 'set content_type=text/html' -s "${subject}" "${recipient}" < "${htmlFilePath}"
done

echo "Email sent successfully."
